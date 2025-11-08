import { APP_BASE_HREF } from '@angular/common';
import { CommonEngine } from '@angular/ssr';
import express from 'express';
import { fileURLToPath } from 'node:url';
import { dirname, join, resolve } from 'node:path';
import bootstrap from './src/main.server';
import cors from 'cors';

// The Express app is exported so that it can be used by serverless Functions.
export function app(): express.Express {
  const server = express();
  
  // Enable CORS for development
  server.use(cors({
    origin: 'http://localhost:4200', // Angular dev server
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization']
  }));

  // Parse JSON bodies
  server.use(express.json());
  
  const serverDistFolder = dirname(fileURLToPath(import.meta.url));
  const browserDistFolder = resolve(serverDistFolder, '../browser');
  const indexHtml = join(serverDistFolder, 'index.server.html');

  const commonEngine = new CommonEngine();

  server.set('view engine', 'html');
  server.set('views', browserDistFolder);

  // API Routes
  server.get('/api/test', (req, res) => {
    res.json({ message: 'Backend connection successful!' });
  });

  // Mote log endpoints
  server.get('/api/mote', (req, res) => {
    // TODO: Implement getting mote logs
    res.json([]);
  });

  server.post('/api/mote', (req, res) => {
    // TODO: Implement adding mote log
    res.json({ success: true });
  });

  // Patle log endpoints
  server.get('/api/patle', (req, res) => {
    // TODO: Implement getting patle logs
    res.json([]);
  });

  server.post('/api/patle', (req, res) => {
    // TODO: Implement adding patle log
    res.json({ success: true });
  });

  // Serve static files from /browser
  server.get('*.*', express.static(browserDistFolder, {
    maxAge: '1y'
  }));

  // All regular routes use the Angular engine
  server.get('*', (req, res, next) => {
    const { protocol, originalUrl, baseUrl, headers } = req;

    commonEngine
      .render({
        bootstrap,
        documentFilePath: indexHtml,
        url: `${protocol}://${headers.host}${originalUrl}`,
        publicPath: browserDistFolder,
        providers: [{ provide: APP_BASE_HREF, useValue: baseUrl }],
      })
      .then((html) => res.send(html))
      .catch((err) => next(err));
  });

  return server;
}

function run(): void {
  const port = process.env['PORT'] || 4000;

  // Start up the Node server
  const server = app();
  server.listen(port, () => {
    console.log(`Node Express server listening on http://localhost:${port}`);
  });
}

run();

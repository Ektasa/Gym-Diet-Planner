# Frontend-Backend Connection Setup Guide

## ✅ What Was Fixed

### 1. **Created API Service**
- Created centralized API service (`api.service.ts`)
- All API calls now go through this service
- Proper HTTP headers included
- Better error handling

### 2. **Updated Login Component**
- Now uses the API service instead of direct HTTP calls
- Added error messages for user feedback
- Added loading state
- Better error handling with user-friendly messages

### 3. **Added Proxy Configuration**
- Created `proxy.conf.json` for development
- Configured Angular to use proxy for API calls
- This helps avoid CORS issues during development

### 4. **Improved Error Handling**
- Shows connection errors to users
- Validates input before sending requests
- Provides feedback when backend is not running

## 🚀 How to Connect Frontend and Backend

### Step 1: Start the Backend (Spring Boot)

1. **Make sure MySQL is running:**
   ```bash
   # Check if MySQL is running
   # Default: localhost:3306
   # Database: login
   # Username: root
   # Password: 1234
   ```

2. **Start Spring Boot application:**
   ```bash
   cd E:\gym\Gym-Diet-Planner\gym
   mvn spring-boot:run
   ```
   
   Or if using Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Verify backend is running:**
   - Open browser: `http://localhost:8080`
   - You should see Spring Boot welcome page or no error
   - Check console for: "Started DietPlannerApplication"

### Step 2: Start the Frontend (Angular)

1. **Navigate to Angular directory:**
   ```bash
   cd Angular/dietplanner
   ```

2. **Start Angular development server:**
   ```bash
   npm start
   ```
   
   Or:
   ```bash
   ng serve
   ```

3. **Verify frontend is running:**
   - Open browser: `http://localhost:4200`
   - You should see the home page

### Step 3: Test the Connection

1. **Open the login page:**
   - Navigate to: `http://localhost:4200/login`

2. **Try to login:**
   - Enter username and password
   - Click "Sign In"
   - Check browser console (F12) for any errors

3. **Check for connection:**
   - If backend is running: You'll see success message
   - If backend is NOT running: You'll see error message: "Connection failed. Please check if the backend server is running on port 8080."

## 🔧 Configuration Files

### Backend Configuration
- **Port:** 8080 (default Spring Boot)
- **CORS:** Configured for `http://localhost:4200`
- **Database:** MySQL on `localhost:3306`

### Frontend Configuration
- **Port:** 4200 (default Angular)
- **API URL:** `http://localhost:8080`
- **Proxy:** Configured in `proxy.conf.json`

## 📝 API Endpoints

All endpoints are prefixed with `/login`:

- **POST** `/login/submit` - Login/Register
- **GET** `/login/getuser` - Get all users
- **PUT** `/login/update` - Update user
- **DELETE** `/login/delete/{id}` - Delete user

## 🐛 Troubleshooting

### Issue: "Connection failed" error

**Possible causes:**
1. Backend is not running
   - **Solution:** Start Spring Boot application

2. Backend is running on different port
   - **Solution:** Check `application.properties` for port configuration
   - Update `api.service.ts` if port is different

3. CORS errors in browser console
   - **Solution:** Check `WebConfig.java` - CORS is already configured
   - Make sure backend allows `http://localhost:4200`

4. MySQL connection error
   - **Solution:** 
     - Make sure MySQL is running
     - Check database credentials in `application.properties`
     - Database `login` should exist

### Issue: "404 Not Found" error

**Possible causes:**
1. Backend endpoint doesn't exist
   - **Solution:** Check `LoginController.java` - endpoints are configured

2. Wrong URL in frontend
   - **Solution:** Check `api.service.ts` - URLs are correct

### Issue: Frontend shows blank page

**Possible causes:**
1. Angular build errors
   - **Solution:** Check console for TypeScript errors
   - Run `npm install` if dependencies are missing

2. Routing issues
   - **Solution:** Check `app-routing.module.ts` - routes are configured

## ✅ Verification Checklist

- [ ] MySQL database is running
- [ ] Spring Boot backend is running on port 8080
- [ ] Angular frontend is running on port 4200
- [ ] No CORS errors in browser console
- [ ] Login endpoint returns success response
- [ ] Error messages display correctly when backend is down

## 📞 Testing the Connection

### Test 1: Backend Running
1. Start backend: `mvn spring-boot:run`
2. Start frontend: `npm start`
3. Go to login page
4. Enter credentials
5. Should see success message

### Test 2: Backend Not Running
1. Stop backend
2. Start frontend: `npm start`
3. Go to login page
4. Enter credentials
5. Should see error: "Connection failed. Please check if the backend server is running on port 8080."

## 🎯 Next Steps

1. Test all API endpoints
2. Add signup functionality
3. Add user session management
4. Add protected routes
5. Add logout functionality


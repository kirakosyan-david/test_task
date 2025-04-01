# REST API Documentation

## Запуск проекта

1. Запустите Docker Compose:
   ```sh
   docker-compose up -d
   ```
2. Запустите приложение:
   ```sh
   mvn spring-boot:run
   ```

## User Requests

### Add User
**POST** `http://localhost:8080/api/users`
```json
{
  "name": "Иван Иванов",
  "email": "Val@example.com",
  "age": 30,
  "weight": 75.5,
  "height": 180.0,
  "goal": "MAINTENANCE"
}
```

### Edit User
**PUT** `http://localhost:8080/api/users/1`
```json
{
  "name": "Иван Иванов",
  "email": "V@example.com",
  "age": 30,
  "weight": 75.5,
  "height": 180.0,
  "goal": "MAINTENANCE"
}
```

### Get All Users
**GET** `http://localhost:8080/api/users`

### Get User by ID
**GET** `http://localhost:8080/api/users/1`

### Delete User by ID
**DELETE** `http://localhost:8080/api/users/1`

---

## Dish Requests

### Add Dish
**POST** `http://localhost:8080/api/dishes`
```json
{
  "name": "харчо",
  "caloriesPerServing": 250.5,
  "protein": 25.3,
  "fats": 8.2,
  "carbs": 30.1
}
```

### Edit Dish
**PUT** `http://localhost:8080/api/dishes/1`
```json
{
  "name": "пюре",
  "caloriesPerServing": 250.5,
  "protein": 25.3,
  "fats": 8.2,
  "carbs": 30.1
}
```

### Get All Dishes
**GET** `http://localhost:8080/api/dishes`

### Get Dish by ID
**GET** `http://localhost:8080/api/dishes/1`

### Delete Dish by ID
**DELETE** `http://localhost:8080/api/dishes/1`

---

## Food Requests

### Add Food
**POST** `http://localhost:8080/api/foods`
```json
{
  "totalCalories": 50
}
```

### Edit Food
**PUT** `http://localhost:8080/api/foods/1/1`
```json
{
  "totalCalories": 500
}
```

### Get All Foods
**GET** `http://localhost:8080/api/foods`

### Get Food by ID
**GET** `http://localhost:8080/api/foods/1`

### Delete Food by ID
**DELETE** `http://localhost:8080/api/foods/1`

---

## Food Dish Requests

### Add Food Dish
**POST** `http://localhost:8080/api/food-dishes`
```json
{
  "foodId": 1,
  "dishId": 1,
  "servingSize": 2.0,
  "totalCalories": 400.0
}
```

### Edit Food Dish
**PUT** `http://localhost:8080/api/food-dishes/1`
```json
{
  "foodId": 1,
  "dishId": 1,
  "servingSize": 4.5,
  "totalCalories": 156.0
}
```

### Get All Food Dishes
**GET** `http://localhost:8080/api/food-dishes`

### Get Food Dish by ID
**GET** `http://localhost:8080/api/food-dishes/1`

### Delete Food Dish by ID
**DELETE** `http://localhost:8080/api/food-dishes/1`

---

## Daily Report Requests

### Add Daily Report
**POST** `http://localhost:8080/api/daily-reports`
```json
{
  "userId": 1,
  "reportDate": "2024-03-28",
  "totalCalories": 255.5,
  "isWithinLimit": true
}
```

### Edit Daily Report
**PUT** `http://localhost:8080/api/daily-reports/3`
```json
{
  "userId": 1,
  "reportDate": "2025-04-30",
  "totalCalories": 255.5,
  "isWithinLimit": true
}
```

### Get All Daily Reports
**GET** `http://localhost:8080/api/daily-reports`

### Get Daily Report by ID and Date
**GET** `http://localhost:8080/api/daily-reports/9/2024-03-28`

### Check Daily Report by ID and Date
**GET** `http://localhost:8080/api/daily-reports/9/check/2024-03-28`

### Delete Daily Report by ID
**DELETE** `http://localhost:8080/api/daily-reports/9`


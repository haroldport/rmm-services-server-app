# ☕🚀 Remote Monitoring and Management (RMM)

## 🏁 How To Start

### 📖 Requirements
- Java runtime version 1.8 or later
- Gradle version 7.x

### 🚀 Up and running
1. Clone repository: ```git clone git@github.com:haroldport/rmm-services-server-app.git```
2. Execute `make all` to create the project JAR, up and running the application.
3. The above command also run a docker container with a PostgreSql version 13 database, with the following credentials:
   ```
   host: localhost
   username and password: rmm
   database: postgres
   port: 5444
   ```
4. When the database is raised, the `services` table is populated, with the services that appear in the requirements.
5. The application should be accessible at localhost:8080 (Make sure nothing using port 8080).

## 👨‍💻 API documentation

### 🔓 Unsecured endpoints
Create a new customer (register account):
```javascript
POST /auth/signup

# curl example
curl --request POST \
     --url http://localhost:8080/auth/signup \
     --header 'Content-Type: application/json' \
     --data '{
         "username": "example",
         "password": "Test1234"
    }'
```

Login (Sign in):
```javascript
POST /auth/login

# curl example

curl --request POST \
     --url http://localhost:8080/auth/login \
     --header 'Content-Type: application/json' \
     --data '{
        "username": "example",
        "password": "Test1234"
     }'

# response example

{
   "data": {
       "customerId": "1fccb8dc-e540-4dd2-b98c-e86d1300ef23",
       "customerUsername": "example",
       "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjQwMzMwMTgzLCJleHAiOjE2NDA0MTY1ODN9.P4MSkzqdmpP-H7qCDQCzQfKb7odkF_hIMPVOSy2TeBAmWIX2K61NxNMFZK1hP-RMw1dfhWsk6xe5-cUtXMKmaA",
       "tokenType": "Bearer"
   }
}
```

### 🔒 Secured endpoints
Get all available services:
```javascript
GET /services

# curl example

curl --request GET \
     --url http://localhost:8080/services \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjQwMzMwMTgzLCJleHAiOjE2NDA0MTY1ODN9.P4MSkzqdmpP-H7qCDQCzQfKb7odkF_hIMPVOSy2TeBAmWIX2K61NxNMFZK1hP-RMw1dfhWsk6xe5-cUtXMKmaA' \
     --header 'Content-Type: application/json'

# response example

{
   "data": [
      {
         "costs": [
            {
               "price": 5.0,
               "platform": "Windows"
            },
            {
               "price": 7.0,
               "platform": "Mac"
            }
         ],
         "name": "Antivirus",
         "id": "dd226ce6-6c05-4111-b042-cfb7e43d8b48"
      },
      {
         "costs": [
            {
               "price": 3.0,
               "platform": "Windows"
            },
            {
               "price": 3.0,
               "platform": "Mac"
            }
         ],
         "name": "Cloudberry",
         "id": "ac77b045-5ee0-4176-b0f2-e63a6d7252bb"
      }
    ]
}
```

Get list of devices of customer:
```javascript
GET /customers/{customerId}/devices

# curl example

curl --request GET \
     --url http://localhost:8080/customers/202b6b0f-3a35-4edf-bdd2-39d74e90add1/devices \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjQwMzMwMTgzLCJleHAiOjE2NDA0MTY1ODN9.P4MSkzqdmpP-H7qCDQCzQfKb7odkF_hIMPVOSy2TeBAmWIX2K61NxNMFZK1hP-RMw1dfhWsk6xe5-cUtXMKmaA' \
     --header 'Content-Type: application/json'

# response example

{
   "data": [
      {
         "systemName": "Lenovo",
         "id": "2559715c-ebbc-453c-b479-2f9793cb9939",
         "type": "Windows Workstation"
      }
   ]
}
```

Create a new device for customer:
```javascript
POST /customers/{customerId}/devices

# curl example
curl --request POST \
     --url http://localhost:8080/customers/202b6b0f-3a35-4edf-bdd2-39d74e90add1/devices \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjQwMzMwMTgzLCJleHAiOjE2NDA0MTY1ODN9.P4MSkzqdmpP-H7qCDQCzQfKb7odkF_hIMPVOSy2TeBAmWIX2K61NxNMFZK1hP-RMw1dfhWsk6xe5-cUtXMKmaA' \
     --header 'Content-Type: application/json' \
     --data '{
        "systemName": "Lenovo",
        "type": "WINDOWS_WORKSTATION"
       }'
```

Update existing device:
```javascript
PATCH /devices/{deviceId}

# curl example

curl --request PATCH \
     --url http://localhost:8080/devices/2559715c-ebbc-453c-b479-2f9793cb9939 \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjQwMzMwMTgzLCJleHAiOjE2NDA0MTY1ODN9.P4MSkzqdmpP-H7qCDQCzQfKb7odkF_hIMPVOSy2TeBAmWIX2K61NxNMFZK1hP-RMw1dfhWsk6xe5-cUtXMKmaA' \
     --header 'Content-Type: application/json' \
     --data '{
        "systemName": "Dell Precission",
        "type": "WINDOWS_WORKSTATION"
    }'
```

Delete existing device:
```javascript
DELETE /devices/{deviceId}

# curl example

curl --request DELETE \
     --url http://localhost:8080/devices/2559715c-ebbc-453c-b479-2f9793cb9939 \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjQwMzMwMTgzLCJleHAiOjE2NDA0MTY1ODN9.P4MSkzqdmpP-H7qCDQCzQfKb7odkF_hIMPVOSy2TeBAmWIX2K61NxNMFZK1hP-RMw1dfhWsk6xe5-cUtXMKmaA' \
     --header 'Content-Type: application/json'
```

Get list of services of customer:
```javascript
GET /customers/{customerId}/services

# curl example

curl --request GET \
     --url http://localhost:8080/customers/202b6b0f-3a35-4edf-bdd2-39d74e90add1/services \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYXJvbGRwb3J0IiwiaWF0IjoxNjQwMzI2NjMxLCJleHAiOjE2NDA0MTMwMzF9.BWhSIdmR6h9V9HjS5aC09zpTo3dQfKpdJKXG0unlbUQsFlj2qp6wRjpHVyaEsUm4lAZaW010yn3CjQ_-Ym7FRA' \
     --header 'Content-Type: application/json'

# response example

{
   "data": [
      {
         "costs": [
            {
               "price": 1.0,
               "platform": "Windows"
            },
            {
               "price": 1.0,
               "platform": "Mac"
            }
         ],
         "name": "TeamViewer",
         "id": "6fc77457-44da-48a4-8153-42dae4115b03"
      },
      {
         "costs": [
            {
               "price": 3.0,
               "platform": "Windows"
            },
            {
               "price": 3.0,
               "platform": "Mac"
            }
         ],
         "name": "Cloudberry",
         "id": "ac77b045-5ee0-4176-b0f2-e63a6d7252bb"
      },
      {
         "costs": [
            {
               "price": 5.0,
               "platform": "Windows"
            },
            {
               "price": 7.0,
               "platform": "Mac"
            }
         ],
         "name": "Antivirus",
         "id": "dd226ce6-6c05-4111-b042-cfb7e43d8b48"
      }
  ]
}
```

Add available service required by customer:
```javascript
POST /customers/{customerId}/services/{serviceId}

# curl example

curl --request POST \
     --url http://localhost:8080/customers/202b6b0f-3a35-4edf-bdd2-39d74e90add1/services/6fc77457-44da-48a4-8153-42dae4115b03 \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYXJvbGRwb3J0IiwiaWF0IjoxNjQwMzI2NjMxLCJleHAiOjE2NDA0MTMwMzF9.BWhSIdmR6h9V9HjS5aC09zpTo3dQfKpdJKXG0unlbUQsFlj2qp6wRjpHVyaEsUm4lAZaW010yn3CjQ_-Ym7FRA' \
     --header 'Content-Type: application/json'
```

Delete service by customer:
```javascript
DELETE /customers/{customerId}/services/{serviceId}

# curl example

curl --request DELETE \
     --url http://localhost:8080/customers/a86eab86-8e17-4492-8cdd-66f075fdd5ed/services/db6bad1d-093e-433d-86b1-9896b3f82703 \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYXJvbGRwb3J0IiwiaWF0IjoxNjQwMzI2NjMxLCJleHAiOjE2NDA0MTMwMzF9.BWhSIdmR6h9V9HjS5aC09zpTo3dQfKpdJKXG0unlbUQsFlj2qp6wRjpHVyaEsUm4lAZaW010yn3CjQ_-Ym7FRA' \
     --header 'Content-Type: application/json'
```

Calculate monthly cost of services:
```javascript
GET /customers/{customerId}/calculate-monthly-cost

# curl example

curl --request GET \
     --url http://localhost:8080/customers/202b6b0f-3a35-4edf-bdd2-39d74e90add1/calculate-monthly-cost \
     --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYXJvbGRwb3J0IiwiaWF0IjoxNjQwMzI2NjMxLCJleHAiOjE2NDA0MTMwMzF9.BWhSIdmR6h9V9HjS5aC09zpTo3dQfKpdJKXG0unlbUQsFlj2qp6wRjpHVyaEsUm4lAZaW010yn3CjQ_-Ym7FRA' \
     --header 'Content-Type: application/json'

# response example

{
   "data": {
       "monthlyCost": 71.0
   }
}
```

## 🧪 Test
The API has acceptance, integration and unit tests. To execute them:

```make test```

## 🤝 Support

Support by Harold Portocarrero

## Stay in touch

- 👨‍💻 - [Harold Portocarrero](https://github.com/haroldport)

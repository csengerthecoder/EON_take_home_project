# E.ON Take Home Project

## 📦 Tech Stack

* **Frontend:** React + Vite
* Link: https://github.com/romansndlr/react-vite-realworld-example-app
* **Backend:** Django REST Framework (Docker)
* Link: https://github.com/Sean-Miningah/realWorld-DjangoRestFramework
* **E2E Tests:** Java + Selenium Grid

## 🚀 Getting Started

### The documentation of the repos help if you get stuck.

### 1. Start Backend
In root folder:
```bash
docker compose up
```

### 2. Start Frontend
In root folder: 
```bash
npm install
npm run dev
```

Frontend runs on Vite dev server, backend runs in Docker containers.

## 🧪 Running Tests

Selenium Grid + Java tests are used for end-to-end browser automation.

Run the tests after both frontend and backend are running.

---

### Start Selenium Grid in PowerShell

Navigate to the folder where your Selenium jar is located and run:

```
java -jar selenium-server.jar standalone
```

This will start the Grid hub and node together (standalone mode).
By default, Grid will be available at:

```
http://localhost:4444
```

### Run Tests on Grid

Once Grid is running, simply execute:

```
mvn test
```

Your tests will connect to the Grid and run remotely.
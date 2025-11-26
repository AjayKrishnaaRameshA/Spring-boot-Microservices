import axios  from 'axios';

const EMPLOYEE_SERVICE_BASE_URL: string = "http://localhost:9191/employee";

const EMPLOYEE_ID: number = 10;

class EmployeeService {
    getEmployee() {
        return axios.get(`${EMPLOYEE_SERVICE_BASE_URL}/${EMPLOYEE_ID}`);
    }
}

export default new EmployeeService();
import {Component, type JSX } from 'react';
import EmployeeService from '../service/EmployeeService';

interface EmployeeDto {
    // Define the structure of employee object
     firstName:string,
     lastName:string,
     email:string;
    
}

interface DepartmentDto {
    // Define the structure of department object
    departmentName:string,
    departmentCode:string,
    departmentDescription:string
}

// interface OrganizationDto{

// }

interface EmployeeComponentState {
    employeeDto: EmployeeDto;
    departmentDto: DepartmentDto;
    
}

class EmployeeComponent extends Component<{}, EmployeeComponentState> {

    constructor(props: {}) {
        super(props);
        
         this.state = {
             employeeDto: {} as EmployeeDto,
             departmentDto: {} as DepartmentDto
             
         }
    }

    componentDidMount(): void {
        EmployeeService.getEmployee().then((response) => {
            
            this.setState({ employeeDto: response.data.employeeDto});
            this.setState({ departmentDto: response.data.departmentDto });
            
            console.log(response.data?.employeeDto);
            console.log(response.data?.departmentDto);
            
        });
    }

    render(): JSX.Element {
        return (
            <div> <br/> <br/>
                <div className='card col-md-10 offset-mid-15'> 
                    <h3 className='text-center card-header'>View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong>{this.state.employeeDto.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Last Name: </strong>{this.state.employeeDto.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee Email: </strong>{this.state.employeeDto.email}</p>
                        </div>
                    </div><br/><br/>
                    <h3 className='text-center card-header'>View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department Name: </strong>{this.state.departmentDto.departmentName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department Description: </strong>{this.state.departmentDto.departmentDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong>{this.state.departmentDto.departmentCode}</p>
                        </div>
                    </div>



                </div>
                
            </div>
        );
    }
}

export default EmployeeComponent;
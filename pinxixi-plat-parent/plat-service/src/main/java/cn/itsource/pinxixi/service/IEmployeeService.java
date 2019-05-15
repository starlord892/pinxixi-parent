package cn.itsource.pinxixi.service;

import cn.itsource.pinxixi.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IEmployeeService extends IService<Employee> {

    Employee login(String username, String password);

}

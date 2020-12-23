package edu.JamesTang.onlineExam.Model;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @author JamesTang
 * @date 2020/12/23 23:08
 */

public class ContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {


        //手动取消驱动程序的注册：
        Enumeration drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = (Driver) drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("deregistering jdbc driver: "+driver);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error deregistering driver"+driver);
            }
        }

        AbandonedConnectionCleanupThread.uncheckedShutdown();
    }
}

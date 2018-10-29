package service.sqlImpl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import db.TransactionManager;
import entity.User;
import service.UserService;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private TransactionManager transactionManager;
    private UserDao sqlDao;

    public UserServiceImpl(DataSource dataSource) {
        sqlDao = new UserDaoImpl();
        transactionManager = new TransactionManager(dataSource);
    }


    @Override
    public void addUser(User user) throws SQLException {
        transactionManager.execute(() -> {
            User userBuf = sqlDao.findByEmail(user.getEmail());
            if (Objects.isNull(userBuf)) {
                 sqlDao.addUser(user);
            }
            return 1;
        });
    }


    @Override
    public User findByEmail(String login) throws SQLException {
       return transactionManager.execute(() -> sqlDao.findByEmail(login));
    }
}

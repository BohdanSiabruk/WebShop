package schedule;


import db.TransactionManager;
import enumeration.Status;
import util.UtilSQl;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class StatusWriter {

    public void write(DataSource dataSource) {
        Executors.newScheduledThreadPool(5).scheduleAtFixedRate(new ScheduleTask(dataSource), 5, 5, TimeUnit.SECONDS);
    }


    private class ScheduleTask implements Runnable {
        private TransactionManager transactionManager;
        private String sql = "update orders set status='" + Status.fORMED.status + "' where status='accepted'";

        ScheduleTask(DataSource dataSource) {
            this.transactionManager = new TransactionManager(dataSource);
        }


        @Override
        public void run() {
            while (true) {
                try {
                    transactionManager.execute(() -> UtilSQl.writeStatus(sql));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

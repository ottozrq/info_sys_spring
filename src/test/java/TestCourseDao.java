import com.ottozhang.ism.dao.impl.CourseDaoImpl;
import com.ottozhang.ism.dataModel.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zhangruoqiu on 2017/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/appContext.xml"})
public class TestCourseDao {
    @Inject
    CourseDaoImpl courseDao;
    @Inject
    SessionFactory sessionFactory;
    @Test
    public void testCourseDao(){
//       List<Course> courseList = courseDao.show();
//        for (Course course:courseList){
//            System.out.println(course);
//        }
        String queryString = "from Course " +
        "group by title " +
        "order by title";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(queryString);
        List<Course> courseList = query.list();
        System.out.println(courseList);
        session.close();
        for (Course course:courseList){
            System.out.println(course);
        }
    }
}

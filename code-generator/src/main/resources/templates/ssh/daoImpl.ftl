package ${package}

import com.yxz.apps.cms.common.dao.impl.hibernate.GenericDaoByHibernate;
import com.yxz.apps.cms.peijian.dao.OrderDao;
import com.yxz.apps.cms.po.hibernate.Order;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class OrderDaoImpl extends GenericDaoByHibernate<Order, Long> implements OrderDao {

@Resource
private HibernateTemplate hibernateTemplate;

@Override
protected HibernateTemplate getHibernateTemplate() {
return hibernateTemplate;
}

}
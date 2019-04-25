package cn.kawhi.service.impl;

import cn.kawhi.dao.UserDao;
import cn.kawhi.dao.impl.UserDaoImpl;
import cn.kawhi.domain.Manager;
import cn.kawhi.domain.PageBean;
import cn.kawhi.domain.User;
import cn.kawhi.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public Manager login(Manager manager) {
       return dao.findUserByUsernameAndPassword(manager.getUsername(),manager.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //3.调用dao查询中的记录数
        int totalCount = dao.findTotalCount(condition);
        //5.计算总页码
        int totalPage = (totalCount % rows)== 0 ? (totalCount / rows) : (totalCount/rows)+1;
        //处理页码的边界问题
        if(currentPage >= totalPage){
            currentPage = totalPage;
        }
        if(currentPage <= 0){
            currentPage = 1;
        }
        //设置参数
        pb.setTotalPage(totalPage);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //4.调用dao查询每页展示的信息，存到List
        //计算开始查询的索引
        int start = (currentPage - 1)*rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);
        return pb;
    }
}

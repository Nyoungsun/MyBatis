package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;

	public static UserDAO userDAO = new UserDAO();

	public static UserDAO getInstance() {
		return userDAO;
	}

	public UserDAO() {
		InputStream inputStream;

		try {
			// Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); //문자단위로
			// Read
			inputStream = Resources.getResourceAsStream("mybatis-config.xml"); // 바이트단위로 Read
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertUser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); // 생성
		sqlSession.insert("userSQL.insert", userDTO); // userMapper.xml안에 있는 태그 id와 넘길 데이터
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();

		return list;
	}

	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();

		return userDTO;
	}

	public void updateUser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.updateUser", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public void deleteUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<UserDTO> searchUser(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.searchUser", map);
		sqlSession.close();

		return list;
	}
	

}
package member.dao;

import model.Member;

public interface Dao {
	void insert(Member m);
	Member select(String id);
	void update(Member m);
	void delete(String id);
}

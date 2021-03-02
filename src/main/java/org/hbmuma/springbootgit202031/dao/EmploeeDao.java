package org.hbmuma.springbootgit202031.dao;

import org.hbmuma.springbootgit202031.domain.Emploee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmploeeDao {
    private static Map<Integer, Emploee> emploees = null;

    static {
        emploees = new HashMap<>();
        emploees.put(1001, new Emploee(1001, "aaa", "aaa@qq.com"));
        emploees.put(1002, new Emploee(1002, "bbb", "bbb@qq.com"));
        emploees.put(1003, new Emploee(1003, "ccc", "ccc@qq.com"));
        emploees.put(1004, new Emploee(1004, "ddd", "ddd@qq.com"));
        emploees.put(1005, new Emploee(1005, "eee", "eee@qq.com"));
    }

    private static int initId = 1006;

    public void save(Emploee emploee){
        if(emploee.getId() == 0){
            emploee.setId(initId++);
        }
        emploees.put(emploee.getId(), emploee);
    }

    public Collection<Emploee> getAll(){ return emploees.values(); }

    public Emploee get(Integer id){ return emploees.get(id); }

    public void delete(Integer id){ emploees.remove(id); }


}

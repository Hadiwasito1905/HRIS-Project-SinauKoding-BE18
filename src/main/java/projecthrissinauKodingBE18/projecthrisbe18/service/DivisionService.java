package projecthrissinauKodingBE18.projecthrisbe18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projecthrissinauKodingBE18.projecthrisbe18.dao.BaseDAO;
import projecthrissinauKodingBE18.projecthrisbe18.dao.DivisionDAO;
import projecthrissinauKodingBE18.projecthrisbe18.entity.Division;

@Service
public class DivisionService extends BaseService<Division> {

    @Autowired
    private DivisionDAO dao;

    @Override
    protected BaseDAO<Division> getDAO() {
        return dao;
    }

    public Division findByName(Division param) {
        return dao.findByName(param);
    }
}

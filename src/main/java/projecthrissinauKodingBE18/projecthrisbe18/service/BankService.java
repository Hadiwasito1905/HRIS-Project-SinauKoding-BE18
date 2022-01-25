package projecthrissinauKodingBE18.projecthrisbe18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projecthrissinauKodingBE18.projecthrisbe18.dao.BankDAO;
import projecthrissinauKodingBE18.projecthrisbe18.dao.BaseDAO;
import projecthrissinauKodingBE18.projecthrisbe18.entity.Bank;

@Service
public class BankService extends BaseService<Bank> {

    @Autowired
    private BankDAO dao;

    @Override
    protected BaseDAO<Bank> getDAO() {
        return dao;
    }

    public Bank findByName(Bank param) {
        return dao.findByName(param);
    }

}

package projecthrissinauKodingBE18.projecthrisbe18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projecthrissinauKodingBE18.projecthrisbe18.dao.BaseDAO;
import projecthrissinauKodingBE18.projecthrisbe18.dao.PositionDAO;
import projecthrissinauKodingBE18.projecthrisbe18.entity.Position;

@Service
public class PositionService extends BaseService<Position> {

    @Autowired
    private PositionDAO dao;

    @Override
    protected BaseDAO<Position> getDAO() {
        return dao;
    }

    public Position findByName(Position param) {
        return dao.findByName(param);
    }
}

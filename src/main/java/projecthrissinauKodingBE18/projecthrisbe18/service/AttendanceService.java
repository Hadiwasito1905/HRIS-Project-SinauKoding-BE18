package projecthrissinauKodingBE18.projecthrisbe18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projecthrissinauKodingBE18.projecthrisbe18.ProjectHrisBe18Application;
import projecthrissinauKodingBE18.projecthrisbe18.dao.AttendanceDAO;
import projecthrissinauKodingBE18.projecthrisbe18.dao.BaseDAO;
import projecthrissinauKodingBE18.projecthrisbe18.entity.Attendance;

import java.util.Date;

@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;

    @Override
    protected BaseDAO<Attendance> getDAO(){
        return dao;
    }

//    @Autowired
//    private EmployeeService employeeService;

//    @Transactional
//    public Attendance save(Attendance entity){
//        entity.setDate(new Date());
//        entity.setStartTime(new Date());
//        entity.setEmployee(employeeService.findbyUserId(ProjectHrisBe18Application.getCurrentUser()));
//
//        return dao.save(entity);
//    }
    @Transactional
    public Attendance update(Attendance entity){
        if (entity.getId() != null){
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setEndTime(entity.getEndTime() != null
                    ? entity.getEndTime()
                    : new Date());

            entity.setEndTime(reference.getEndTime());

            return entity;
        }

        return null;
    }

    @Transactional
    public Attendance startRest(Attendance entity){
        if (entity.getId() != null) {
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setRestStartTime(entity.getRestStartTime() != null
                    ? entity.getRestStartTime()
                    : new Date());

            entity.setRestStartTime(reference.getRestStartTime());

            return entity;
        }

        return null;
    }

    @Transactional
    public Attendance endRest(Attendance entity){
        if (entity.getId() != null) {
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setRestEndTime(entity.getRestEndTime() != null
                    ? entity.getRestEndTime()
                    : new Date());

            entity.setRestEndTime((reference.getRestEndTime()));

            return entity;
        }

        return null;
    }

//    @Transactional
//    public Collection<Attendance> findByDate(Attendance entity, Date startDate, Date endDate){
//        Collection<Attendance> result = dao.findByDate(entity, startDate, endDate);
//        return result.size() > 0 ? result : new ArrayList<>();
//    }

}

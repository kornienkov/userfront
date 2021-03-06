package com.mybankonline.userfront.service.UserServiceImpl;

import com.mybankonline.userfront.dao.AppointmentDao;
import com.mybankonline.userfront.domain.Appointment;
import com.mybankonline.userfront.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    public Appointment createAppointment(Appointment appointment){
        return appointmentDao.save(appointment);
    }

    public List<Appointment> findAll(){
        return appointmentDao.findAll();
    }

    public Appointment findAppointment(Long id){
        return appointmentDao.findById(id).orElse(null);
    }

    public void confirmAppointment(Long id){
        Appointment appointment = findAppointment(id);
        appointment.setConfirmed(true);
        appointmentDao.save(appointment);
    }
}

package service;

import model.Clazz;
import repository.ClazzRepository;
import repository.IClazzRepository;

import java.util.List;

public class ClazzService implements IClazzService {
    private IClazzRepository clazzRepository = new ClazzRepository();
    @Override
    public List<Clazz> findByAll() {
        return clazzRepository.findByAll();
    }
}

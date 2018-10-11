package service;

import dao.ScreenDAO;
import daoImpl.ScreenDAOImpl;
import pojo.Screen;

import java.util.List;

public class ScreenService {
    private ScreenDAO screenDAO = new ScreenDAOImpl();

    public List<Screen> getAll() {
        return screenDAO.getAll();
    }
}

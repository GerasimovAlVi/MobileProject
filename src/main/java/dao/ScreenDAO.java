package dao;

import pojo.Screen;

import java.util.List;

public interface ScreenDAO {
    public boolean add(Screen screen);

    public Screen getById(Integer id);

    public boolean updateById(Screen screen);

    public boolean deleteById(Integer id);

    public Screen getByName(String name);

    public List<Screen> getAll();
}

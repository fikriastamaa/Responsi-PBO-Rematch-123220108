/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.*;

/**
 *
 * @author Fikri
 */
public interface datahewanimplement {
    public void insert(datahewan p);
    public void update(datahewan p);
    public void delete(int id);
    public List<datahewan> getAll();
}

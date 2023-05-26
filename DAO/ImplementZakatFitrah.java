package DAO;

import Model.ModZakatFitrah;
import java.util.List;

public interface ImplementZakatFitrah {
    public void insert(ModZakatFitrah mzf);
    public void delete(int no);
    public void update(ModZakatFitrah mzf);
    public List<ModZakatFitrah> getAll();
    public List<ModZakatFitrah> getCari(String nama);
    
}

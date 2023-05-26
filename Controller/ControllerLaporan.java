package Controller;

import View.FormLaporan;

public class ControllerLaporan {
    FormLaporan frame;
    
    public ControllerLaporan(FormLaporan frame){
        this.frame = frame;
    }
    
    public int splitTotal(){
        String totalDana = frame.getTf_total().getText();
        String[] Split = totalDana.split(" ");
        int TotalDana = Integer.parseInt(Split[1]);       
        return TotalDana;
    }
    
    public void setAlokasi(){
        double fakirMiskin = splitTotal() * 0.6;
        double fisabilillah = splitTotal() * 0.21;
        double amil = splitTotal() * 0.15;
        double muamalaf = splitTotal() * 0.012;
        double gharmin = splitTotal() * 0.015;
        double ibnuSabil = splitTotal() * 0.002;
        
        frame.getTf_fakirmiskin().setText("Rp. " + String.valueOf(fakirMiskin));
        frame.getTf_fisabilillah().setText("Rp. " + String.valueOf(fisabilillah));
        frame.getTf_amil().setText("Rp. " + String.valueOf(amil));
        frame.getTf_muamalaf().setText("Rp. " + String.valueOf(muamalaf));
        frame.getTf_gharmin().setText("Rp. " + String.valueOf(gharmin));
        frame.getTf_ibnusabil().setText("Rp. " + String.valueOf(ibnuSabil));  
    }
    
}

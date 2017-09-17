package DrosteEffect;
import ui.DrosteUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;

public class DrosteEffect {
static final int UI_WIDTH = 611;
static final int UI_HEIGTH= 740;
int xPlace;
int yPlace;
DrosteUserInterface ui;
	
	DrosteEffect(){
		ui = UserInterfaceFactory.getDrosteUI(UI_WIDTH, UI_HEIGTH);
		yPlace = 0;
		xPlace = 0;
	}
	
	void start(int breedte, int lengte,int xPlace,int yPlace){
		ui.place(DrosteUserInterface.ESCHER_IMAGE, xPlace, yPlace, breedte, lengte);
		if (breedte != 1){
			
			breedte = (int) (breedte/2.425+0.5);
			lengte = (int) (lengte/2.492+0.5);
			xPlace = (int) (breedte/1.575+0.5);
			this.xPlace += xPlace;
			yPlace = (int) (lengte/1.344+0.5);
			this.yPlace += yPlace;
		start(breedte,lengte,this.xPlace,this.yPlace);
		}else{
			UIAuxiliaryMethods.showMessage("Click 'ok'  or press enter to Exit");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new DrosteEffect().start(UI_WIDTH, UI_HEIGTH,0,0);

	}

}

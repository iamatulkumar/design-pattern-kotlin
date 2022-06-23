package structural.facade;

import structural.facade.devices.Fan;
import structural.facade.devices.Light;
import structural.facade.devices.SoundBar;
import structural.facade.devices.TV;
import structural.facade.devices.kitchen.*;
import structural.facade.devices.livingroom.*;

import java.util.List;

public class HomeFacade {

	Fan fan;
	LivingRoomFireTV4KStick stick;
	Light livingRoomLight;
	SoundBar soundBar;
	TV tv;

	CoffeeMaker maker;
	ElectricGrill grill;
	Light kitchenLight;
	Microwave microwave;
	Refrigerator refrigerator;

	public HomeFacade() {
		super();
		fan = new LivingRoomFan();
		tv = new LivingRoomTV();
		stick = new LivingRoomFireTV4KStick(tv);
		livingRoomLight = new LivingRoomLight();
		soundBar = new LivingRoomSoundBar(tv);

		maker = new CoffeeMaker();
		grill = new ElectricGrill();
		kitchenLight = new KitchenLight();
		microwave = new Microwave();
		refrigerator = new Refrigerator();
	}

	public void playMovieOnNetflix(String movieName) {
		fan.on();
		fan.increase();
		livingRoomLight.on();
		tv.on();
		((LivingRoomTV) tv).setSource("HDMI ARC");
		stick.on();
		soundBar.on();
		soundBar.setSoundMode("Dolby Atmos");
		stick.openApp("Netflix");
		stick.selectContent(movieName);
		((LivingRoomLight) livingRoomLight).dim();
		soundBar.volume(20);
		stick.play();
	}

	public void prepareFood(List<String> pizzaNames) {
		kitchenLight.on();
		// normally refrigerator runs always. so no need to turn on.
		refrigerator.partyMode(); // for fast cooling
		microwave.on();
		microwave.setOnPreHeat(200, 5);
		microwave.grillOn();
		grill.on();
		maker.on();
		pizzaNames.forEach(pizzaName -> microwave.bake(pizzaName, 400, 10));
	}

	public void stopMovie() {
		stick.closeApp();
		stick.off();
		soundBar.off();
		tv.off();
		((LivingRoomLight) livingRoomLight).bright();
		fan.off();
	}

	public void closeKitchen() {
		refrigerator.normalMode();
		grill.off();
		maker.off();
		microwave.off();
	}
}

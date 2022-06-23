package structural.facade.devices.livingroom;

import structural.facade.devices.SoundBar;
import structural.facade.devices.TV;

public class LivingRoomSoundBar extends SoundBar {

	protected TV tv;

	public LivingRoomSoundBar(TV tv) {
		super("LivingRoomSoundBar");
		this.tv = tv;
	}

	public TV tv() {
		return tv;
	}
	
}

package icu.azim.wagrapple.components;

import icu.azim.wagrapple.WAGrappleMod;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.util.sync.EntitySyncedComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class GrappledPlayerComponent implements EntitySyncedComponent{
	private boolean grappled = false;
	private int lineId = -1;
	private PlayerEntity owner;
	
	public GrappledPlayerComponent(PlayerEntity owner) {
		this.owner = owner;
	}
	
	
	@Override
	public void fromTag(NbtCompound tag) {
		grappled = tag.getBoolean("grappled");
		lineId = tag.getInt("lineid");
	}

	@Override
	public NbtCompound toTag(NbtCompound tag) {
		tag.putBoolean("grappled", grappled);
		tag.putInt("lineid", lineId);
		return tag;
	}


	public boolean isGrappled() {
		return grappled;
	}


	public void setGrappled(boolean b) {
		grappled = b;
	}


	public int getLineId() {
		return lineId;
	}

	public void setLineId(int id) {
		lineId = id;
	}


	@Override
	public ComponentType<?> getComponentType() {
		return WAGrappleMod.GRAPPLE_COMPONENT;
	}


	@Override
	public Entity getEntity() {
		return owner;
	}
	
	@Override
	public String toString() {
		return "grappled: "+grappled+" lineId"+lineId;
	}
	
}

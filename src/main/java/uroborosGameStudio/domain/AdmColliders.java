package uroborosGameStudio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

public class AdmColliders implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<Collider> colliders;
	
	public AdmColliders()
	{
		this.colliders = new ArrayList<Collider>();
	}

	public List<Collider> getColliders() {
		return colliders;
	}
	
	public void addCollider(Collider collider)
	{
		this.colliders.add(collider);
	}

	public Collider getCollitionIndex(int index) 
	{
		return this.colliders.get(index);
	}

	public void removeColliderIndex(int index) 
	{
		this.colliders.remove(index);
	}

	public void evalColliders(EcmaScriptEngine engine, String name) 
	{
		this.colliders.forEach(collider -> collider.evalCollider(engine, name));
	}

	public boolean hasColliders() 
	{
		return ! colliders.isEmpty();
	}

}

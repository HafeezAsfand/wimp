package com.el.ally.wimp.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Award;
import com.el.ally.wimp.repositories.ActorRepository;


@RestController
@RequestMapping("/api/actors")
public class ActorController 
{
	@Autowired
	private ActorRepository actorRepository;

	@GetMapping("/")
	public List<Actor> getActor()
	{
		List<Actor> Actor = actorRepository.findAll();
		return Actor;
	}
	
	@GetMapping("{id}")
	public Actor getSpecificActor(@PathVariable Long id)
	{
		Actor actor = actorRepository.findOne(id);
		return actor;
	}
	
	@PostMapping("/")
	public Actor createActor(@RequestBody Actor actor)
	{
		Actor newActor = actorRepository.save(actor);
		return newActor;
	}
	
	@PutMapping("{id}")
	public Actor getSpecificActor(@PathVariable Long id, @RequestBody Actor actor)
	{
		actor.setId(id);
		Actor updatedActor = actorRepository.save(actor);
		return updatedActor;
	}
	
	@DeleteMapping("{id}")
	public Actor deleteActor(@PathVariable Long id)
	{
		Actor originalActor = actorRepository.findOne(id);
		actorRepository.delete(originalActor);
		return originalActor;
	}
	
	// post method for award
	@PostMapping("/{actorsId}/awards")
	public Actor createAward(@PathVariable long actorsId, @RequestBody Award award)
	{
		Actor actor = actorRepository.findOne(actorsId);
		actor.setAward(award);
		
		return actorRepository.save(actor);
		
}
}

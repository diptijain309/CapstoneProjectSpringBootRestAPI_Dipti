package com.jd.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jd.teams.model.ScrumTeams;

public interface SearchTeamRepository extends JpaRepository<ScrumTeams, String>{

}

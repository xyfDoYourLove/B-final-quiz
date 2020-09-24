package com.example.demo.repository;

import com.example.demo.domain.entity.GroupDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupDo, Long> {

}

package com.example.demo.service;

import com.example.demo.domain.entity.GroupDo;
import com.example.demo.domain.vo.GroupVo;
import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

  private final GroupRepository groupRepository;

  public GroupService(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  public List<GroupVo> findAllGroups() {
    return this.groupRepository.findAll()
            .stream()
            .map(it -> it.toBo().toVo())
            .collect(Collectors.toList());

  }
}

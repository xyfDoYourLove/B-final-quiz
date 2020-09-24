package com.example.demo.service;

import com.example.demo.common.constant.ExceptionMessageConstant;
import com.example.demo.domain.entity.GroupDo;
import com.example.demo.domain.vo.GroupVo;
import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.exception.EntityNotExistException;
import com.example.demo.exception.GroupNameNotRepeatException;
import com.example.demo.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

  public GroupVo editGroupName(Long groupId, GroupVo groupNew) {
    Optional<GroupDo> groupOptionalExist = groupRepository.findById(groupId);
    if (!groupOptionalExist.isPresent()) {
      throw new EntityNotExistException(ExceptionMessageConstant.GROUP_NOT_EXIST, groupId.toString());
    }
    if (groupOptionalExist.get().getName().equals(groupNew.getName())) {
      throw new GroupNameNotRepeatException(ExceptionMessageConstant.GROUP_NAME_NOT_REPEAT, groupNew.getName());    }

    GroupDo groupExist = groupOptionalExist.get();
    groupExist.setName(groupNew.getName());
    return groupRepository.save(groupExist).toBo().toVo();
  }
}

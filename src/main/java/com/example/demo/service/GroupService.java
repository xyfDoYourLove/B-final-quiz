package com.example.demo.service;

import com.example.demo.common.constant.ExceptionMessageConstant;
import com.example.demo.domain.entity.GroupDo;
import com.example.demo.domain.entity.TraineeDo;
import com.example.demo.domain.entity.TrainerDo;
import com.example.demo.domain.vo.GroupVo;
import com.example.demo.domain.vo.TraineeVo;
import com.example.demo.exception.EntityNotExistException;
import com.example.demo.exception.GroupNameNotRepeatException;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {

  private final GroupRepository groupRepository;

  private final TraineeRepository traineeRepository;

  private final TrainerRepository trainerRepository;

  public GroupService(GroupRepository groupRepository, TraineeRepository traineeRepository, TrainerRepository trainerRepository) {
    this.groupRepository = groupRepository;
    this.traineeRepository = traineeRepository;
    this.trainerRepository = trainerRepository;
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

  public List<GroupVo> autoGrouping() {
    groupRepository.deleteAll();

    List<TrainerDo> allTrainer = trainerRepository.findAll();
    List<TraineeDo> allTrainee = traineeRepository.findAll();

    Collections.shuffle(allTrainer);
    Collections.shuffle(allTrainee);

    List<GroupDo> allGroup = new ArrayList<>();
    for (int i = 0, startIndex = 0, endIndex = 0; i < allTrainer.size() / 2; i++) {
      int traineesSize = getTraineesSize(allTrainee, allTrainer.size() / 2, i);
      endIndex += traineesSize;
      allGroup.add(GroupDo.builder()
              .name(i+1+"组")
              .trainees(allTrainee.subList(startIndex, endIndex))
              .trainers(allTrainer.subList(2*i, 2*(i+1)))
              .build());

      startIndex += traineesSize;
    }

    setGroupedIsTrue(allGroup);

    return allGroup.stream().map(it -> it.toBo().toVo()).collect(Collectors.toList());
  }

  private int getTraineesSize(List<TraineeDo> allTrainee, int groupCount, int index) {
    int traineesSize = allTrainee.size() / groupCount;
    int extraSize = allTrainee.size() % groupCount;
    if ( extraSize >= index + 1) {
      traineesSize += 1;
    }
    return traineesSize;
  }

  private void setGroupedIsTrue(List<GroupDo> allGroup) {
    allGroup.stream()
            .map(group -> {
              traineeRepository.saveAll(group.getTrainees().stream()
                      .map((it) -> {
                        it.setGrouped(true);
                        return it;
                      }).collect(Collectors.toList()));
              trainerRepository.saveAll(group.getTrainers().stream()
                      .map((it) -> {
                        it.setGrouped(true);
                        return it;
                      }).collect(Collectors.toList()));
              return group;
            }).collect(Collectors.toList());
  }

}

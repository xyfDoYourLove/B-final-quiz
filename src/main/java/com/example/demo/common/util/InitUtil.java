package com.example.demo.common.util;

import com.example.demo.domain.entity.GroupDo;
import com.example.demo.domain.entity.TraineeDo;
import com.example.demo.domain.entity.TrainerDo;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitUtil {

  List<String> traineeNames = Arrays.asList("沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇",
          "杨思雨", "江雨舟", "廖燊", "胡晓", "但杰", "盖迈达", "肖美琦", "黄云洁", "齐瑾浩",
          "刘亮亮", "肖逸凡", "王作文", "郭瑞凌", "李明豪", "党泽", "肖伊佐", "贠晨曦", "李康宁",
          "马庆", "商婕", "余榕", "谌哲", "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强", "刘轲",
          "廖浚斌", "凌凤仪");

  List<String> trainerNames = Arrays.asList("老大", "老二", "老三", "老四", "老五", "老六");

  List<Integer> groupIds = Arrays.asList(1, 2, 3);

  private final TraineeRepository traineeRepository;

  private final TrainerRepository trainerRepository;

  private final GroupRepository groupRepository;

  public InitUtil(TraineeRepository traineeRepository, TrainerRepository trainerRepository, GroupRepository groupRepository) {
    this.traineeRepository = traineeRepository;
    this.trainerRepository = trainerRepository;
    this.groupRepository = groupRepository;
  }

  public void initTraineeRepo() {

    List<TraineeDo> traineeDoList = traineeNames.stream()
            .map(it -> {
              return TraineeDo.builder()
                      .name(it)
                      .email("xyf@thoughtworks.com")
                      .github("xyf")
                      .office("北京")
                      .zoomId("1234567")
                      .grouped(false)
                      .group(null)
                      .build();
            })
            .collect(Collectors.toList());

    List<TrainerDo> trainerDoList = trainerNames.stream()
            .map(it -> TrainerDo.builder()
                    .name(it)
                    .grouped(false)
                    .group(null)
                    .build())
            .collect(Collectors.toList());

    List<GroupDo> groupDoList = groupIds.stream()
            .map(it -> GroupDo.builder()
                    .id(it)
                    .name(it + "组")
                    .trainees(traineeDoList.subList(1*it-1, 10*it))
                    .trainers(trainerDoList.subList(1*it-1, 2*it))
                    .build())
            .collect(Collectors.toList());
    groupRepository.saveAll(groupDoList);

    traineeRepository.saveAll(traineeDoList);
    trainerRepository.saveAll(trainerDoList);

  }

}

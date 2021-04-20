package com.prime.task.prime.dto;

import com.prime.task.prime.model.AttachmentModel;
import com.prime.task.prime.model.NoteModel;
import com.prime.task.prime.model.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProjectItemDTO {

    private Set<TaskModel> tasks;
    private Set<NoteModel> notes;
    private Set<AttachmentModel> attachments;
}

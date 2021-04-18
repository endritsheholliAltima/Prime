

package com.prime.task.prime.model;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class TaskModel extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "asigned_id")
    private String asignedId;

    @Column(name = "reported_id")
    private String reportedId;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "projectId",
            foreignKey = @ForeignKey(
                    name = "fk_tasks_project_id"
            )
    )
    @JsonIgnore
    private Project project;
}

package com.prime.task.prime.repository;

        import com.prime.task.prime.model.AttachmentModel;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentModel,Long> {

}

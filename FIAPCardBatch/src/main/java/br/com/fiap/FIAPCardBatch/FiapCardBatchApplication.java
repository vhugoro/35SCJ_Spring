package br.com.fiap.FIAPCardBatch;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
@EnableBatchProcessing
public class FiapCardBatchApplication {

	Logger logger = LoggerFactory.getLogger(FiapCardBatchApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FiapCardBatchApplication.class, args);
	}
	
	@Bean
	public FlatFileItemReader<Aluno> itemReader(@Value("${file.input}") Resource resource) {
		
		return new FlatFileItemReaderBuilder<Aluno>()
				.delimited().delimiter(";")
				.names("rm", "nome")
				.resource(resource)
				.targetType(Aluno.class)
				.name("File Item Reader")
				.build();
	}

	@Bean
	public ItemProcessor<Aluno, Aluno> itemProcessor(){
		return aluno -> {
			aluno.setNome(aluno.getNome().toUpperCase());
			aluno.setRm(aluno.getRm());
			return aluno;
		};
	}
	
	@Bean
	public ItemWriter<Aluno> itemWriter (DataSource dataSource){
		return new JdbcBatchItemWriterBuilder()
				.beanMapped()
				.dataSource(dataSource)
				.sql("insert into tb_aluno (rm, nome) values (:rm, :nome)")
				.build();
	}
	
	@Bean
	@Qualifier("stepchunk")
	public Step stepChunk(StepBuilderFactory stepBuilderFactory, ItemReader<Aluno> itemReader,
			ItemProcessor<Aluno, Aluno> itemProcessor, ItemWriter<Aluno> itemWriter) {
		return stepBuilderFactory.get("step processar aluno")
				.<Aluno, Aluno>chunk(2)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, @Qualifier("stepchunk") Step step) {
		return jobBuilderFactory.get("job processor clients")
				.start(step)
				.build();
	}
}

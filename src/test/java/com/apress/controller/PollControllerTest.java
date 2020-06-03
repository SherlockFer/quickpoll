package com.apress.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.apress.domain.Poll;
import com.apress.repository.PollRepository;

@ExtendWith(MockitoExtension.class)
public class PollControllerTest {

	private static Long POLL_ID_1 = new Long(111);
	private static Long POLL_ID_2 = new Long(222);

	@InjectMocks
	private PollController pollController;
	@Mock
	private PollRepository pollRepository;

	@Test
	public void shouldReturnAllPost() {
		prepare();

		ResponseEntity<Iterable<Poll>> response = pollController.getAllPolls();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.hasBody()).isTrue();
		assertThat(IterableUtils.size(response.getBody())).isEqualTo(2);
	}

	private void prepare() {
		Collection<Poll> polls = createPolls();
		when(pollRepository.findAll()).thenReturn(polls);
	}

	private Collection<Poll> createPolls() {
		Collection<Poll> polls = new ArrayList<Poll>();

		Poll p1 = new Poll();
		p1.setId(POLL_ID_1);
		p1.setQuestion("Question-1");
		polls.add(p1);

		Poll p2 = new Poll();
		p2.setId(POLL_ID_2);
		p2.setQuestion("Question-2");
		polls.add(p2);

		return polls;
	}

}

package com.example.api_java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_java.dto.request.DailyRequestId;
import com.example.api_java.dto.request.GeoDTO;
import com.example.api_java.dto.request.MapDataPairDTO;
import com.example.api_java.dto.request.MapDataPointDTO;
import com.example.api_java.model.GeoDistance;
import com.example.api_java.model.JobDailyPlan;
import com.example.api_java.repository.GeoDistanceRepository;
import com.example.api_java.repository.JobDailyPlanRepository;

@Service
public class DailyRoutingService {
    @Autowired
    private JobDailyPlanRepository jobDailyPlanRepository;

    @Autowired
    private GeoDistanceRepository geoDistanceRepository;

    public Optional<List<MapDataPairDTO>> getDailyRouting(DailyRequestId jobRequest) {
        Optional<JobDailyPlan> result = jobDailyPlanRepository.findJobDailyPlanById(jobRequest.getJob_daily_plan_id());

        if (result.isPresent()) {
            JobDailyPlan jobDailyPlan = result.get();

            // Get startGeoId from jobDailyPlan
            String geoStartId = jobDailyPlan.getJobWeeklyPlan().getStartGeo().getId();
            // System.out.println(geoStartId);

            // get List<JobDailyPlan> from jobDailyPlan's assignee and action_date
            List<JobDailyPlan> jobList = jobDailyPlanRepository.findByAssigneeAndActionDate(jobDailyPlan.getAssignee(),
                    jobDailyPlan.getActionDate());
            // System.out.println(jobList);

            // Make List<String> from geoStartId and geoId from jobList
            List<String> geoIds = jobList.stream()
                    .map(job -> job.getGeo().getId())
                    .collect(Collectors.toList());
            geoIds.add(0, geoStartId);
            // System.out.println(geoIds);

            // get GeoDistance from geoIds
            List<Optional<GeoDistance>> geoResult = createPairsFromGeoList(geoIds);
            // System.out.println(geoResult);

            // return Optional<List<MapDataPairDTO>> from List<Optional<GeoDistance>>
            List<MapDataPairDTO> mapDataPairs = geoResult.stream()
                    .map(geoDistance -> {
                        MapDataPointDTO fromGeo = new MapDataPointDTO(geoDistance.get().getFromGeo().getName(),
                                geoDistance.get().getFromGeo().getAddress(),
                                new GeoDTO(geoDistance.get().getFromGeo().getLongitude(),
                                        geoDistance.get().getFromGeo().getLatitude()));
                        MapDataPointDTO toGeo = new MapDataPointDTO(geoDistance.get().getToGeo().getName(),
                                geoDistance.get().getToGeo().getAddress(),
                                new GeoDTO(geoDistance.get().getToGeo().getLongitude(),
                                        geoDistance.get().getToGeo().getLatitude()));
                        return new MapDataPairDTO(fromGeo, toGeo, geoDistance.get().getDistance());
                    })
                    .collect(Collectors.toList());

            return Optional.of(mapDataPairs);

            // return Optional.of(List.of(new MapDataPairDTO(null, null)));
        }

        return Optional.empty();
    }

    private List<Optional<GeoDistance>> createPairsFromGeoList(List<String> geoIds) {
        List<Optional<GeoDistance>> pairs = new ArrayList<>();
        for (int i = 0; i < geoIds.size() - 1; i++) {
            Optional<GeoDistance> pair = geoDistanceRepository.findByFromGeoIdAndToGeoId(geoIds.get(i),
                    geoIds.get(i + 1));
            pairs.add(pair);
        }
        return pairs;
    }
}

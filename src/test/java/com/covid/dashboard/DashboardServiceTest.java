package com.covid.dashboard;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DashboardServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getLatestCasesCountTest() throws Exception {

        String response = "{\"success\":true,\"data\":{\"summary\":{\"total\":26530132,\"confirmedCasesIndian\":26530084,\"confirmedCasesForeign\":48,\"discharged\":23425467,\"deaths\":299266,\"confirmedButLocationUnidentified\":0},\"unofficial-summary\":[{\"source\":\"covid19india.org\",\"total\":7945975,\"recovered\":7198877,\"deaths\":119538,\"active\":626192}],\"regional\":[{\"loc\":\"Andaman and Nicobar Islands\",\"confirmedCasesIndian\":6820,\"confirmedCasesForeign\":0,\"discharged\":6441,\"deaths\":101,\"totalConfirmed\":6820},{\"loc\":\"Andhra Pradesh\",\"confirmedCasesIndian\":1562060,\"confirmedCasesForeign\":0,\"discharged\":1341355,\"deaths\":10022,\"totalConfirmed\":1562060},{\"loc\":\"Arunachal Pradesh\",\"confirmedCasesIndian\":23867,\"confirmedCasesForeign\":0,\"discharged\":20836,\"deaths\":95,\"totalConfirmed\":23867},{\"loc\":\"Assam\",\"confirmedCasesIndian\":365620,\"confirmedCasesForeign\":0,\"discharged\":307548,\"deaths\":2667,\"totalConfirmed\":365620},{\"loc\":\"Bihar\",\"confirmedCasesIndian\":685574,\"confirmedCasesForeign\":0,\"discharged\":636224,\"deaths\":4442,\"totalConfirmed\":685574},{\"loc\":\"Chandigarh\",\"confirmedCasesIndian\":58129,\"confirmedCasesForeign\":0,\"discharged\":52172,\"deaths\":692,\"totalConfirmed\":58129},{\"loc\":\"Chhattisgarh\",\"confirmedCasesIndian\":945694,\"confirmedCasesForeign\":0,\"discharged\":862660,\"deaths\":12494,\"totalConfirmed\":945694},{\"loc\":\"Dadra and Nagar Haveli and Daman and Diu\",\"confirmedCasesIndian\":9925,\"confirmedCasesForeign\":0,\"discharged\":9390,\"deaths\":4,\"totalConfirmed\":9925},{\"loc\":\"Delhi\",\"confirmedCasesIndian\":1415218,\"confirmedCasesForeign\":1,\"discharged\":1360898,\"deaths\":23013,\"totalConfirmed\":1415219},{\"loc\":\"Goa\",\"confirmedCasesIndian\":144838,\"confirmedCasesForeign\":1,\"discharged\":124255,\"deaths\":2341,\"totalConfirmed\":144839},{\"loc\":\"Gujarat\",\"confirmedCasesIndian\":784675,\"confirmedCasesForeign\":1,\"discharged\":695026,\"deaths\":9523,\"totalConfirmed\":784676},{\"loc\":\"Haryana\",\"confirmedCasesIndian\":733614,\"confirmedCasesForeign\":14,\"discharged\":678220,\"deaths\":7415,\"totalConfirmed\":733628},{\"loc\":\"Himachal Pradesh\",\"confirmedCasesIndian\":177725,\"confirmedCasesForeign\":0,\"discharged\":146230,\"deaths\":2707,\"totalConfirmed\":177725},{\"loc\":\"Jammu and Kashmir\",\"confirmedCasesIndian\":267313,\"confirmedCasesForeign\":0,\"discharged\":214664,\"deaths\":3513,\"totalConfirmed\":267313},{\"loc\":\"Jharkhand\",\"confirmedCasesIndian\":329072,\"confirmedCasesForeign\":0,\"discharged\":301705,\"deaths\":4801,\"totalConfirmed\":329072},{\"loc\":\"Karnataka\",\"confirmedCasesIndian\":2398925,\"confirmedCasesForeign\":0,\"discharged\":1891042,\"deaths\":24658,\"totalConfirmed\":2398925},{\"loc\":\"Kerala\",\"confirmedCasesIndian\":2322138,\"confirmedCasesForeign\":8,\"discharged\":2025319,\"deaths\":7170,\"totalConfirmed\":2322146},{\"loc\":\"Ladakh\",\"confirmedCasesIndian\":17277,\"confirmedCasesForeign\":0,\"discharged\":15585,\"deaths\":176,\"totalConfirmed\":17277},{\"loc\":\"Lakshadweep\",\"confirmedCasesIndian\":6418,\"confirmedCasesForeign\":0,\"discharged\":4394,\"deaths\":22,\"totalConfirmed\":6418},{\"loc\":\"Madhya Pradesh\",\"confirmedCasesIndian\":760963,\"confirmedCasesForeign\":0,\"discharged\":691427,\"deaths\":7483,\"totalConfirmed\":760963},{\"loc\":\"Maharashtra\",\"confirmedCasesIndian\":5553222,\"confirmedCasesForeign\":3,\"discharged\":5111095,\"deaths\":87300,\"totalConfirmed\":5553225},{\"loc\":\"Manipur\",\"confirmedCasesIndian\":43322,\"confirmedCasesForeign\":0,\"discharged\":36258,\"deaths\":674,\"totalConfirmed\":43322},{\"loc\":\"Meghalaya\",\"confirmedCasesIndian\":28878,\"confirmedCasesForeign\":0,\"discharged\":20989,\"deaths\":435,\"totalConfirmed\":28878},{\"loc\":\"Mizoram\",\"confirmedCasesIndian\":10220,\"confirmedCasesForeign\":0,\"discharged\":7736,\"deaths\":31,\"totalConfirmed\":10220},{\"loc\":\"Nagaland\",\"confirmedCasesIndian\":19845,\"confirmedCasesForeign\":0,\"discharged\":14967,\"deaths\":271,\"totalConfirmed\":19845},{\"loc\":\"Odisha\",\"confirmedCasesIndian\":679530,\"confirmedCasesForeign\":0,\"discharged\":577983,\"deaths\":2456,\"totalConfirmed\":679530},{\"loc\":\"Puducherry\",\"confirmedCasesIndian\":94612,\"confirmedCasesForeign\":0,\"discharged\":75947,\"deaths\":1325,\"totalConfirmed\":94612},{\"loc\":\"Punjab\",\"confirmedCasesIndian\":533973,\"confirmedCasesForeign\":0,\"discharged\":459681,\"deaths\":13089,\"totalConfirmed\":533973},{\"loc\":\"Rajasthan\",\"confirmedCasesIndian\":909519,\"confirmedCasesForeign\":2,\"discharged\":779601,\"deaths\":7590,\"totalConfirmed\":909521},{\"loc\":\"Sikkim\",\"confirmedCasesIndian\":12808,\"confirmedCasesForeign\":0,\"discharged\":9393,\"deaths\":221,\"totalConfirmed\":12808},{\"loc\":\"Tamil Nadu\",\"confirmedCasesIndian\":1806855,\"confirmedCasesForeign\":6,\"discharged\":1502537,\"deaths\":20046,\"totalConfirmed\":1806861},{\"loc\":\"Telangana\",\"confirmedCasesIndian\":551035,\"confirmedCasesForeign\":0,\"discharged\":504970,\"deaths\":3106,\"totalConfirmed\":551035},{\"loc\":\"Tripura\",\"confirmedCasesIndian\":46099,\"confirmedCasesForeign\":0,\"discharged\":37625,\"deaths\":463,\"totalConfirmed\":46099},{\"loc\":\"Uttarakhand\",\"confirmedCasesIndian\":310468,\"confirmedCasesForeign\":1,\"discharged\":246806,\"deaths\":5734,\"totalConfirmed\":310469},{\"loc\":\"Uttar Pradesh\",\"confirmedCasesIndian\":1665175,\"confirmedCasesForeign\":1,\"discharged\":1551716,\"deaths\":18978,\"totalConfirmed\":1665176},{\"loc\":\"West Bengal\",\"confirmedCasesIndian\":1248668,\"confirmedCasesForeign\":0,\"discharged\":1102772,\"deaths\":14208,\"totalConfirmed\":1248668}]},\"lastRefreshed\":\"2021-05-23T11:04:21.274Z\",\"lastOriginUpdate\":\"2021-05-23T02:30:00.000Z\"}";

        Mockito
                .when(restTemplate.getForEntity(
                        "https://api.rootnet.in/covid19-in/stats/latest", String.class))
          .thenReturn(new ResponseEntity(response, HttpStatus.OK));

        DashboardService dashboardService = new DashboardService(restTemplate);
        ReflectionTestUtils.setField(dashboardService, "covidApiUrl", "https://api.rootnet.in/covid19-in/stats/latest");
        String data = dashboardService.getLatestCovidCount();
        assertEquals(data, response);
    }

}

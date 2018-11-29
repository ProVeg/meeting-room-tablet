package de.synyx.android.reservator.config;

import de.synyx.android.reservator.data.AttendeeAdapter;
import de.synyx.android.reservator.data.AttendeeAdapterImpl;
import de.synyx.android.reservator.data.EventAdapter;
import de.synyx.android.reservator.data.EventAdapterImpl;
import de.synyx.android.reservator.data.EventRepositoryImpl;
import de.synyx.android.reservator.data.RoomRepositoryImpl;
import de.synyx.android.reservator.domain.event.EventRepository;
import de.synyx.android.reservator.domain.room.RoomRepository;
import de.synyx.android.reservator.screen.main.lobby.LoadRoomsUseCase;
import de.synyx.android.reservator.util.SchedularFacadeImpl;
import de.synyx.android.reservator.util.SchedulerFacade;


/**
 * @author  Max Dobler - dobler@synyx.de
 */
public class MainConfig {

    private MainConfig() {

        // hide
    }

    public static void init() {

        Registry.put(AttendeeAdapter.class, new AttendeeAdapterImpl());
        Registry.put(EventAdapter.class, new EventAdapterImpl());
        Registry.put(EventRepository.class, new EventRepositoryImpl());
        Registry.put(SchedulerFacade.class, new SchedularFacadeImpl());
        Registry.put(RoomRepository.class, new RoomRepositoryImpl());
        Registry.put(LoadRoomsUseCase.class, new LoadRoomsUseCase());
    }
}
import { useState } from "react";
import Popover from "./Popover";
import "./StationSelector.css";
import { useQuery } from "react-query";
import { queryStations } from "../lib/api";
import { Station } from "../lib/types";

interface StationSelectorProps {
  selectStation: (station: Station) => void;
}

function StationSelector({ selectStation }: StationSelectorProps) {
  const [query, setQuery] = useState("");

  const { data } = useQuery(["stations", query], () => queryStations(query), {
    keepPreviousData: true,
    enabled: !!query,
  });

  const stations = data?.stations;

  return (
    <Popover
      triggerWrapper={({ triggerProps }) => (
        <button className="dropbutton" {...triggerProps}>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth="2"
              d="M19 9l-7 7-7-7"
            ></path>
          </svg>
        </button>
      )}
    >
      <div className="station-selector">
        <input
          type="text"
          placeholder="Search stations"
          className="search"
          value={query}
          onChange={(event) => setQuery(event.target.value)}
        />
        <div className="stations-list">
          {!stations &&
            new Array(10)
              .fill(null)
              .map((_, index) => (
                <div key={index} className="station-skeleton"></div>
              ))}
          {stations?.map((station, index) => (
            <button
              key={station.id ?? `station-${index}`}
              className="station"
              onClick={() => {
                selectStation(station);
              }}
            >
              <span>{station.name}</span>
            </button>
          ))}
        </div>
      </div>
    </Popover>
  );
}

export default StationSelector;

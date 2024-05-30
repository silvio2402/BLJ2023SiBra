import type { Station, StationboardItem } from "./types";

const BASE_URL = "https://transport.opendata.ch/v1";

interface StationsResponse {
  stations: Station[];
}

export async function queryStations(query: string) {
  const url = new URL(`${BASE_URL}/locations?limit=10&type=station`);
  url.searchParams.append("query", query);
  const response = await fetch(url);
  const data = await response.json();
  console.log("queryStations", data);
  return data as StationsResponse;
}

interface StationboardResponse {
  station: Station;
  stationboard: StationboardItem[];
}

export async function queryStationboard(id: string) {
  const url = new URL(`${BASE_URL}/stationboard`);
  url.searchParams.append("id", id);
  const response = await fetch(url);
  const data = await response.json();
  console.log("queryStationboard", data);
  return data as StationboardResponse;
}

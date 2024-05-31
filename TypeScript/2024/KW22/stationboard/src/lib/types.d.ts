export interface Coordinate {
  type?: string;
  x?: number;
  y?: number;
}

export interface Station {
  id?: string;
  name?: string;
  score?: number;
  coordinate: Coordinate;
  distance?: number;
  icon?: string;
}

export interface Prognosis {
  platform?: string;
  arrival?: string;
  departure?: string;
  capacity1st?: number;
  capacity2nd?: number;
}

export interface Stop {
  station: Station;
  arrival?: string;
  arrivalTimestamp?: number;
  departure?: string;
  departureTimestamp?: number;
  delay?: number;
  platform?: string;
  prognosis: Prognosis;
  realtimeAvailability?: boolean;
  location: Station;
}

export interface StationboardItem {
  stop: Stop;
  name?: string;
  category?: string;
  subcategory?: string;
  categoryCode?: number;
  number?: string;
  operator?: string;
  to?: string;
  passList: Stop[];
  capacity1st?: number;
  capacity2nd?: number;
}

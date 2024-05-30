import "./StationTitle.css";

interface StationTitleProps {
  stationName: string;
}

function StationTitle({ stationName }: StationTitleProps) {
  return <h1 className="station-title">{stationName}</h1>;
}

export default StationTitle;

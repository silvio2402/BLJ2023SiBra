import "./Skeleton.css";

interface SkeletonProps {
  width: number;
  height: number;
  style?: React.CSSProperties;
}

function Skeleton({ width, height, style }: SkeletonProps) {
  return <div className="skeleton" style={{ width, height, ...style }} />;
}

export default Skeleton;

import React, { useEffect, useId, useRef, useState } from "react";
import "./Popover.css";

interface PopoverProps {
  children: React.ReactNode;
  triggerWrapper: (obj: {
    triggerProps: Pick<
      React.HTMLProps<HTMLButtonElement>,
      "onClick" | "aria-haspopup" | "aria-expanded" | "aria-controls"
    >;
  }) => React.ReactNode;
}

function Popover({ children, triggerWrapper }: PopoverProps) {
  const [isVisible, setIsVisible] = useState(false);
  const toggleVisibility = () => setIsVisible((prev) => !prev);
  const popoverId = useId();

  const containerRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (
        containerRef.current &&
        !containerRef.current.contains(event.target as Node)
      )
        // Close the popover if clicked outside
        setIsVisible(false);
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return (
    <div ref={containerRef} className="popover-container">
      {triggerWrapper({
        triggerProps: {
          onClick: toggleVisibility,
          "aria-haspopup": true,
          "aria-expanded": isVisible,
          "aria-controls": popoverId,
        },
      })}
      {isVisible && (
        <div
          className="popover-content"
          id={popoverId}
          role="dialog"
          aria-modal="true"
        >
          {children}
        </div>
      )}
    </div>
  );
}

export default Popover;
